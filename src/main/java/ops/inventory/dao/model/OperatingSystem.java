package ops.inventory.dao.model;


import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity(label="OperatingSystem")
public class OperatingSystem {

	@GraphId
	private Long id;
	private String name;
	private String kernalVersion;
	
	@Relationship(type = "INSTALLED_OS", direction = "INCOMING")
	private Set<Server> servers = new HashSet<>();
	
	public OperatingSystem() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public void addServer(Server server) {
		
    	servers.add(server);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKernalVersion() {
		return kernalVersion;
	}

	public void setKernalVersion(String kernalVersion) {
		this.kernalVersion = kernalVersion;
	}

	public Set<Server> getServers() {
		return servers;
	}

	public void setServers(Set<Server> servers) {
		this.servers = servers;
	}

}
