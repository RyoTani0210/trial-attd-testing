package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features") // Featureファイルのディレクトリ
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example.stepdefinitions") // ステップ定義のパッケージ
public class RunCukesTest {

}

