package com.raupp.md5.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raupp.md5.model.Audio_md5;
import com.raupp.md5.repository.AudioRepository;
@Controller
@RequestMapping(path="/")
public class AudioController{

	  @Autowired
	  private AudioRepository audioRepository;

	  @RequestMapping(path="/add")
	  public @ResponseBody String addNewAudio (@RequestParam String md5
	      , @RequestParam String transcription
	      , @RequestParam String location
	      , @RequestParam String name ) {

	    Audio_md5 audio = new Audio_md5();
	    audio.setMd5(md5);
	    audio.setTranscription(transcription);
	    audio.setLocation(location);
	    audio.setName(name);
	    audioRepository.save(audio);
	    return "Saved";	   
	  }
	  
	  @RequestMapping(path="/all")
	  public @ResponseBody Iterable<Audio_md5> getAllAudios() {
	    return audioRepository.findAll();
	  }
	  
	  @RequestMapping(path="/find")
	  public @ResponseBody Audio_md5 getAudio(@RequestParam String md5) {
		  Audio_md5 au = audioRepository.findByMd5(md5);
		  if(au != null) {
			  return au;
					  
		  }else {
			  au = new Audio_md5();
			  au.setMd5("Não Existe!");
			  au.setTranscription("Não Existe!");
			  au.setLocation("Não Existe!");
			  au.setName("Não Existe!");
			  return au;
		  }
	    
	  }
}
