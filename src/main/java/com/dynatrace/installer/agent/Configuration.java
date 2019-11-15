package com.dynatrace.installer.agent;

import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.util.*;

class Configuration extends BaseConfiguration {

    public Configuration() {
        super("dynatrace-installer-agent.json");
    }

    public JSONObject resourceSchemaJSONObject() {
        return new JSONObject(new JSONTokener(this.getClass().getClassLoader().getResourceAsStream(schemaFilename)));
    }
	/** * Providers should implement this method if your resource has a 'Tags' property to define resource-level tags * @return */ 
	public Map<String, String> resourceDefinedTags(final ResourceModel resourceModel)
	{ 
		return null; 
	}
}
