package io.yawp.driver.postgresql;

import io.yawp.driver.api.Driver;
import io.yawp.driver.api.EnvironmentDriver;
import io.yawp.driver.api.HelpersDriver;
import io.yawp.driver.api.NamespaceDriver;
import io.yawp.driver.api.PersistenceDriver;
import io.yawp.driver.api.QueryDriver;
import io.yawp.driver.api.TransactionDriver;
import io.yawp.driver.postgresql.connection.ConnectionManager;
import io.yawp.driver.postgresql.datastore.PGDatastore;
import io.yawp.repository.Repository;

public class PGDriver implements Driver {

	private Repository r;

	private PGDatastore datastore;

	private ConnectionManager connectionManager;

	@Override
	public void init(Repository r) {
		this.r = r;
		this.datastore = PGDatastore.create(connectionManager);
		this.connectionManager = new ConnectionManager();
	}

	@Override
	public void dispose() {
		connectionManager.dispose();
	}

	@Override
	public PersistenceDriver persistence() {
		return new PGPersistenceDriver(r, datastore);
	}

	@Override
	public QueryDriver query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamespaceDriver namespace() {
		return new PGNamespaceDriver();
	}

	@Override
	public TransactionDriver transaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentDriver environment() {
		return new PGEnvironmentDriver();
	}

	@Override
	public HelpersDriver helpers() {
		// TODO Auto-generated method stub
		return null;
	}

}
