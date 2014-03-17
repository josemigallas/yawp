package endpoint.models.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import endpoint.models.Repository;
import endpoint.models.SimpleObject;
import endpoint.servlet.HttpResponse;
import endpoint.utils.DateUtils;
import endpoint.utils.GAETest;
import endpoint.utils.JsonUtils;

public class ActionTest extends GAETest {

	private Repository r;

	@Before
	public void before() {
		r = new Repository();
	}

	@Test
	public void testSimpleAction() {
		SimpleObject object = new SimpleObject(1, 1l, 1.1, true, DateUtils.toTimestamp("2013/12/26 23:55:01"), "object1");
		r.save(object);

		HttpResponse response = r.action(SimpleObject.class, "PUT", "active", object.getId());		
		object = JsonUtils.from(response.getText(), SimpleObject.class);
		
		assertEquals("i was changed in action", object.getaString());

		object = r.findById(object.getId(), SimpleObject.class);
		assertEquals("i was changed in action", object.getaString());
	}
}
