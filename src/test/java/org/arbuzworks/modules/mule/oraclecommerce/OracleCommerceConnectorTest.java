/**
 * (c) 2003-2014 Arbuz LLC, The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.arbuzworks.modules.mule.oraclecommerce;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.NullPayload;
import static org.junit.Assert.*;

public class OracleCommerceConnectorTest extends FunctionalTestCase {

	@Override
	protected String getConfigResources() {
		return "oracle-commerce-config.xml";
	}

	@Test
	public void testFlow() throws Exception {
		MuleClient client = muleContext.getClient();

		String jsonRequest = "{ \"rql\": \"id=1\",  \"typeRequest\": \"rqlCountQuery\"}";

		MuleMessage result = client.send("http://localhost:8080/oracleTest", jsonRequest, null);
		assertNotNull(result);
		assertNull(result.getExceptionPayload());
		assertFalse(result.getPayload() instanceof NullPayload);
		result.getPayloadAsString();
	}
}
