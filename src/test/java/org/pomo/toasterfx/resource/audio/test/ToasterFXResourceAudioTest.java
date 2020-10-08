/*
 * Copyright © 2020 Mr.Po (ldd_live@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pomo.toasterfx.resource.audio.test;

import javafx.util.Duration;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Throwables;
import org.junit.*;
import org.pomo.toasterfx.ToastBarToasterService;
import org.pomo.toasterfx.model.ToastParameter;
import org.pomo.toasterfx.model.impl.ToastTypes;
import org.pomo.toasterfx.resource.audio.RandomBubbleAudio;
import org.pomo.toasterfx.util.FXUtils;
import org.testfx.api.FxToolkit;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <h2>ToasterFX 音效资源 测试</h2>
 *
 * <p>用于打包和远端测试</p>
 * <br/>
 *
 * <p>创建时间：2020-10-01 09:33:22</p>
 * <p>更新时间：2020-10-01 09:33:22</p>
 *
 * @author Mr.Po
 * @version 1.0
 */
@Slf4j
public class ToasterFXResourceAudioTest {

    /**
     * 消息者服务
     */
    private static ToastBarToasterService toasterService;

    /**
     * <h2>初始化</h2>
     */
    @BeforeClass
    @SneakyThrows
    public static void init() {

        FxToolkit.registerPrimaryStage();

        toasterService = new ToastBarToasterService();
        toasterService.initialize();

        WaitForAsyncUtils.autoCheckException = false;
        WaitForAsyncUtils.printException = false;
    }

    /**
     * <h2>销毁</h2>
     */
    @AfterClass
    public static void destroy() {

        WaitForAsyncUtils.autoCheckException = true;
        WaitForAsyncUtils.printException = true;

        if (toasterService != null)
            FXUtils.smartLater(() -> toasterService.destroy());

        log.info("ToasterFX test end.");
    }

    @After
    public void finish() {

        this.handleException();
        log.info("ToasterFX audio test success.");
    }

    /**
     * <h2>测试随机音效</h2>
     */
    @Test
    @SneakyThrows
    public void execute() {

        ToastParameter parameter = ToastParameter.builder()
                .timeout(Duration.seconds(1))
                .audio(RandomBubbleAudio.DEFAULT)
                .build();

        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 3; i++) {

            toasterService.bomb("ToasterFX", "Hello ToasterFX !", parameter,
                    ToastTypes.INFO, toast -> toast.setOnDock((it, node) -> latch.countDown()));

            TimeUnit.SECONDS.sleep(1);
        }

        boolean flag = latch.await(20, TimeUnit.SECONDS);
        Assert.assertTrue("wait timeout.", flag);

        RandomBubbleAudio.DEFAULT.stop();
    }

    /**
     * <h2>处理异常</h2>
     */
    private void handleException() {

        while (true) {

            try {

                WaitForAsyncUtils.checkException();

            } catch (Throwable throwable) {

                Throwable rootCause = Throwables.getRootCause(throwable);

                // 排除 无法创建音频播放器的异常
                if (!("com.sun.media.jfxmedia.MediaException".equals(rootCause.getClass().getName())
                        && "Could not create player!".equals(rootCause.getMessage()))) {

                    Assert.fail(Throwables.getRootCause(throwable).getMessage());

                } else log.debug("a MediaException was ignored.");

                continue;
            }

            break;
        }
    }
}
