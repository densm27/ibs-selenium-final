package ru.appline.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.appline.framework.managers.InitManager;

public class Hooks {
    public static Scenario scenario;

    @Before
    public void before(Scenario scenario)
    {
        Hooks.scenario = scenario;
        InitManager.initFramework();
    }


    @After
    public void after() {
        InitManager.quitFramework();
    }
}
