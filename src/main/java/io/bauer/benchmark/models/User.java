/**
 * 
 */
package io.bauer.benchmark.models;

import java.util.List;

/**
 * @author jbauer
 *
 */
public class User  
{
	public Long id;
	public String username;
	public List<String> tags;
	
	public User()
	{
		
	}
	/**
	 * @param id
	 * @param username
	 */
	public User(Long id, String username, List<String> tags)
	{
		 
		this.id = id;
		this.username = username;
		this.tags = tags;
	}
	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags()
	{
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags)
	{
		this.tags = tags;
	}
	
	
}
