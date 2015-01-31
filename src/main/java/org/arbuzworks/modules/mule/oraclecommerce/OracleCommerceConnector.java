/**
 * (c) 2003-2014 Arbuz LLC, The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.arbuzworks.modules.mule.oraclecommerce;

import org.arbuzworks.modules.mule.oraclecommerce.client.OracleCommerceClientException;
import org.arbuzworks.modules.mule.oraclecommerce.client.OracleCommerceProxyClient;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.*;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * OracleCommerce Connector.
 */
@Connector(name = "oracle-commerce", schemaVersion = "1.0", description = "OracleCommerce Anypoint Connector", friendlyName = "OracleCommerce")
public class OracleCommerceConnector {
	private OracleCommerceProxyClient client;
	/**
	 * Webservice host.
	 */
	@Configurable
	private String host;
	/**
	 * Webservice port.
	 */
	@Configurable
	private String port;


	/**
	 * Connect.
	 *
	 * @param userName for compilation
	 * @throws ConnectionException exception
	 */
	@Connect
	public void connect(@ConnectionKey @Optional String userName) throws ConnectionException {
		client = new OracleCommerceProxyClient();
		try {
			client.initialize(host, port);
		} catch (OracleCommerceClientException e) {
			throw new ConnectionException(ConnectionExceptionCode.CANNOT_REACH, e.getThirdPartyCode(), e.getMessage());
		}

	}

	/**
	 * Disconnect.
	 */
	@Disconnect
	public void disconnect() {
		client = null;
	}

	/**
	 * Are we connected.
	 */
	@ValidateConnection
	public boolean isConnected() {
		return (client != null);
	}

	/**
	 * Are we connected
	 */
	@ConnectionIdentifier
	public String connectionId() {
		return "OracleCommerce-";
	}

	/**
	 * Perform RQL query.
	 * <p/>
	 * {@sample.xml ../../../doc/oracle-commerce-connector.xml.sample oracle-commerce:perform-r-q-l-query}
	 *
	 * @param repositoryComponentPath Repository Component Path
	 * @param itemDescriptorName      Item Descriptor Name
	 * @param RQLString               Query to be executed
	 * @return array of strings (xml)
	 * @throws OracleCommerceClientException exception
	 */
	@Processor
	public String[] performRQLQuery(String repositoryComponentPath,
									String itemDescriptorName,
									@Default("#[payload.rql]") String RQLString) throws OracleCommerceClientException {
		return client.performRQLQuery(repositoryComponentPath, itemDescriptorName, RQLString);
	}

	/**
	 * Perform RQLCountQuery.
	 * <p/>
	 * {@sample.xml ../../../doc/oracle-commerce-connector.xml.sample oracle-commerce:perform-r-q-l-count-query}
	 *
	 * @param repositoryComponentPath Repository Component Path
	 * @param itemDescriptorName Item Descriptor Name
	 * @param RQLString Query to be executed
	 * @return count of entities
	 * @throws OracleCommerceClientException exception
	 */
	@Processor
	public int performRQLCountQuery(String repositoryComponentPath,
									String itemDescriptorName,
									@Default("#[payload.rql]") String RQLString) throws OracleCommerceClientException {
		return client.performRQLCountQuery(repositoryComponentPath, itemDescriptorName, RQLString);
	}

	/**
	 * Get Repository Item.
	 * <p/>
	 * {@sample.xml ../../../doc/oracle-commerce-connector.xml.sample oracle-commerce:get-repository-item}
	 *
	 * @param repositoryComponentPath Repository Component Path
	 * @param itemDescriptorName Item Descriptor Name
	 * @param repositoryItemId Item id
	 * @return get item of repository - xml string
	 * @throws OracleCommerceClientException exception
	 */
	@Processor
	public String getRepositoryItem(String repositoryComponentPath,
									String itemDescriptorName,
									@Default("#[payload.itemId]") String repositoryItemId) throws OracleCommerceClientException {
		return client.getRepositoryItem(repositoryComponentPath, itemDescriptorName, repositoryItemId);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}