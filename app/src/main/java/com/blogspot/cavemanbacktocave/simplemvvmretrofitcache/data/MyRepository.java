package com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.data;

import com.blogspot.cavemanbacktocave.simplemvvmretrofitcache.magic.NetworkBoundResource;

public class MyRepository {

    private MyRepository myRepository=null;

    public MyRepository getInstance() {
        if(myRepository==null){
            myRepository=new MyRepository();
        }
        return myRepository;
    }

    public void getMyResponseWithCache(){
        /*In case you have both different model refer :
        * https://github.com/mitchtabian/Local-db-Cache-Retrofit-REST-API-MVVM/blob/master/app/src/main/java/com/codingwithmitch/foodrecipes/repositories/RecipeRepository.java
        * */
        //return new NetworkBoundResource<>()
    }
}
