package com.thejoa703.oauth2;

 
public interface UserInfoOAuth2 {
    String getProvider();     
    String getProviderId();    
    String getEmail();        
    String getNickname();    
    String getImage();       
}
