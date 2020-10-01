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
package org.pomo.toasterfx.resource.audio;

import javafx.scene.media.AudioClip;
import org.pomo.toasterfx.model.impl.RandomAudio;

import java.net.URL;
import java.util.stream.IntStream;

/**
 * <h2>随机 - 气泡 - 音频</h2>
 *
 * <p>提供一个单例的随机气泡音频实例</p>
 * <br/>
 *
 * <p>创建时间：2020-09-27 19:18:41</p>
 * <p>更新时间：2020-09-27 19:18:41</p>
 *
 * @author Mr.Po
 * @version 1.0
 */
public class RandomBubbleAudio extends RandomAudio {

    public static final RandomBubbleAudio DEFAULT = new RandomBubbleAudio();

    private RandomBubbleAudio() {
        super(
                IntStream.rangeClosed(1, 4)
                        .mapToObj(it -> "/org/pomo/toasterfx/resource/audio/files/" + it + ".mp3")
                        .map(RandomBubbleAudio.class::getResource)
                        .map(URL::toExternalForm)
                        .map(AudioClip::new)
                        .toArray(AudioClip[]::new)
        );
    }
}
