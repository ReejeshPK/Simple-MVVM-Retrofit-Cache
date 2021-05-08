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
2. Add Room Db annotations, add the new model to room db class
3. Add a DAO with required queries (Remember to wrap it with Live Data < > for getting data from db.)
4. Create Repository
5. Create View Model
6. Call from activity/fragment

Notes:
1. Add Primary key / Composite key and specify index unique=true in models to prevent errors
2. use Conflict strategy according to your needs.
3. Think about Arraylist memory allocation if the list does not refresh / notify dataset changed does not work.
4. For some reason private data member does not work with room db in Java here
5. Use the Retrofit adapter and put it in your retrofit client to get response as live data
6. When using ViewmodelProvier(this) - see usage in fragment/activity see difference when used with
ViewModelProvoider(getActivity()), research on it.

Used:
Retrofit, Room Database, Live Data

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

