package com.felipersumiya.services.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.felipersumiya.domain.json.ComicJson;

@FeignClient(url= "http://gateway.marvel.com/v1/public/comics?ts=1&apikey=3b9cbe70e344955d81eb536fa5e1bf91&hash=88b4384befe49610c2e1d9c73a904c38" , name = "marvel")
public interface ComicMarvelService {
	
	 @GetMapping
	   ComicJson  buscaComics();

}
