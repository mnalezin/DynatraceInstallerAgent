package com.dynatrace.installer.agent;

import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

class Configuration extends BaseConfiguration {

    public Configuration() {
        super("dynatrace-installer-agent.json");
    }
}
