package io.yawp.repository.transformers;

import io.yawp.repository.models.basic.BasicObject;

import java.util.HashMap;
import java.util.Map;

public class BasicObjectTransformer extends Transformer<BasicObject> {

	public Map<String, Object> simple(BasicObject object) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("innerValue", object.getStringValue());
		map.put("innerObject", object);

		return map;
	}

}
