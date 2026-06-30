package com.the703.oauth2;

import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserKakao implements UserInfoOAuth2 {
    private final Map<String, Object> attributes;

    @Override public String getProvider() { return "kakao"; }

    @Override 
    public String getProviderId() { 
        if (attributes == null) return null;
        Object id = attributes.get("id");
        return id != null ? id.toString() : null; 
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, Object> getAccount() {
        if (attributes == null) return null;
        Object account = attributes.get("kakao_account");
        return account instanceof Map ? (Map<String, Object>) account : null;
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, Object> getProfile() {
        Map<String, Object> account = getAccount();
        if (account == null) return null;
        Object profile = account.get("profile");
        return profile instanceof Map ? (Map<String, Object>) profile : null;
    }
    
    @Override 
    public String getEmail() { 
        Map<String, Object> account = getAccount();
        if (account == null) return null;
        Object email = account.get("email");
        return email != null ? email.toString() : null;  
    }

    @Override 
    public String getNickname() {  
        Map<String, Object> profile = getProfile();
        if (profile == null) return null;
        Object nickname = profile.get("nickname");
        return nickname != null ? nickname.toString() : null; 
    }

    @Override
    public String getImage() {
        Map<String, Object> profile = getProfile();
        if (profile == null) return null;
        Object imageUrl = profile.get("profile_image_url");
        return imageUrl != null ? imageUrl.toString() : null;
    }
}


