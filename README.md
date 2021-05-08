# Simple-MVVM-Retrofit-Cache

A simple version of the best MVVM Structure Ive seen :
https://github.com/mitchtabian/Local-db-Cache-Retrofit-REST-API-MVVM

Credits:
https://github.com/mitchtabian

REST API Mocked with:
https://designer.mocky.io/design

GET Request:
https://run.mocky.io/v3/bfc63159-1093-4a00-be39-a7b7ffc9f62b

Steps:
1. Start with the model


Dependencies to use :
 //room db
    def room_version = "2.3.0"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"

    def lifecycle_version = "2.3.1"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
    // Lifecycles only (without ViewModel or LiveData)
    implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"
    // Annotation processor
    //annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    //viewmodel provider
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"

    //for retrofit-model conversion
    implementation 'com.google.code.gson:gson:2.8.6'

