package org.wube.aps.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.wube.aps.messanger.database.DatabaseClass;
import org.wube.aps.messanger.model.Message;
import org.wube.aps.messanger.model.Profile;


public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfile();

	public ProfileService(){
		profiles.put("wube", new Profile(1L, "wubet", "wube", "tuffa"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String profileName){
		return profiles.remove(profileName);
	}

}
