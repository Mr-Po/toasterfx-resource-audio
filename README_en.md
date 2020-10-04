# ToasterFX Audio Resource [![语言：中文](https://img.shields.io/badge/%E8%AF%AD%E8%A8%80-%E4%B8%AD%E6%96%87-brightgreen)](README.md)

[![toasterfx: 1.0.2+](https://img.shields.io/badge/toasterfx-1.0.2%2B-green)](../../../toasterfx)
[![Build Status](https://travis-ci.com/Mr-Po/toasterfx-resource-audio.svg?branch=master)](https://travis-ci.com/Mr-Po/toasterfx-resource-audio)
[![Apache License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](LICENSE)

An audio resource library of [ToasterFX](../../../toasterfx).

## Features
* With the audio of random bubble

## Installation
Maven：
```
<dependency>
    <groupId>com.gitee.pomo</groupId>
    <artifactId>toasterfx-resource-audio</artifactId>
    <version>1.0.2</version>
</dependency>
```
Gradle：
```
compile group: 'com.gitee.pomo', name: 'toasterfx-resource-audio', version: '1.0.2'
```

## Usage
```
ToastBarToasterService service = new ToastBarToasterService();
service.initialize();

// The toast paramter of a random audio is defined.
ToastParameter parameter = ToastParameter.builder()
                .audio(RandomBubbleAudio.DEFAULT)
                .build();

// You can call this method on any thread.
service.bomb("ToasterFX","Hello ToasterFX !",parameter,ToastTypes.INFO);
```
## Screenshot
![0990E73E5E9874011F4714F9AE73E146.gif](https://i.loli.net/2020/09/28/RPShGny2mKedi5r.gif)

For more features and sample demo：[ToasterFX-DEMO](../../../toasterfx-demo).