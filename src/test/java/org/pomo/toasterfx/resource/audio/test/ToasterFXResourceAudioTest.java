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

import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pomo.toasterfx.ToastBarToasterService;
import org.pomo.toasterfx.ToasterFactory;
import org.pomo.toasterfx.ToasterWindow;
import org.pomo.toasterfx.model.ToastParameter;
import org.pomo.toasterfx.model.impl.ToastTypes;
import org.pomo.toasterfx.resource.audio.RandomBubbleAudio;
import org.pomo.toasterfx.util.FXUtils;
import org.testfx.api.FxToolkit;

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

        Stage stage = FxToolkit.registerPrimaryStage();

        ToasterWindow window = new ToasterWindow() {

            {
                stage.setOpacity(0);
                FxToolkit.setupScene(() -> new Scene(new Parent() {
                }));
            }

            @Override
            @SneakyThrows
            public void show() {
                FxToolkit.showStage();
            }

            @Override
            @SneakyThrows
            public void close() {
                FxToolkit.hideStage();
            }

            @Override
            public boolean isShowing() {
                return stage.isShowing();
            }

            @Override
            public ObservableList<String> getStylesheets() {
                return stage.getScene().getStylesheets();
            }

            @Override
            public Window getWindow() {
                return stage;
            }
        };

        ToasterFactory toasterFactory = new ToasterFactory();
        toasterFactory.setWindow(window);

        toasterService = new ToastBarToasterService();
        toasterService.setToasterFactory(toasterFactory);
        toasterService.initialize();
    }

    /**
     * <h2>销毁</h2>
     */
    @AfterClass
    public static void destroy() {

        FXUtils.smartLater(() -> toasterService.destroy());

        log.info("ToasterFX test end.");
    }

    /**
     * <h2>测试随机音效</h2>
     */
    @Test
    @SneakyThrows
    public void execute() {

        ToastParameter parameter = ToastParameter.builder()
                .timeout(Duration.seconds(3))
                .audio(RandomBubbleAudio.DEFAULT)
                .build();

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {

            toasterService.bomb("ToasterFX", "Hello ToasterFX !", parameter, ToastTypes.INFO, toast -> {
                toast.setOnDestroy(it -> latch.countDown());
            });

            TimeUnit.SECONDS.sleep(1);
        }

        boolean flag = latch.await(10, TimeUnit.SECONDS);
        Assert.assertTrue("wait timeout.", flag);

        log.info("ToasterFX audio test success.");
    }
}
