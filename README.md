A simple version of the best MVVM Structure Ive seen : https://github.com/mitchtabian/Local-db-Cache-Retrofit-REST-API-MVVM
_See explanation of concept in the above website._

> Credits and References : https://github.com/mitchtabian

REST API Mocked with: https://designer.mocky.io/design

GET Request: https://run.mocky.io/v3/bfc63159-1093-4a00-be39-a7b7ffc9f62b

It is good to know the following concepts before setpping into MVVM:
1. View Model
2. Live Data
3. Mutable Live Data, Mediator Live Data
4. Room Database
5. Observer pattern

**Steps:**
1. Start with the model
1. Add Room Db annotations, add the new model to room db class
1. Add a DAO with required queries (Remember to wrap it with Live Data < > for getting data from db.)
1. Create Repository
1. Create View Model
1. Call from activity/fragment

***

**Notes:**
* Add Primary key / Composite key and specify index unique=true in models to prevent errors
* Use Conflict strategy according to your needs.
* Think about Arraylist memory allocation if the list does not refresh / notify dataset changed does not work.
* For some reason private data member does not work with room db in Java here
* Use the Retrofit adapter and put it in your retrofit client to get response as live data
* When using ViewmodelProvier(this) - see usage in fragment/activity see difference when used with ViewModelProvoider(getActivity()), research on it.
* Use this line return new NetworkBoundResource<List,List>(AppExecutors.getInstance()){}.getAsLiveData(); and hit Alt+Enter to implement methods

> Used in Project: Retrofit, Room Database, Live Data

***

Dependencies to use :
`//room db `
`def room_version = "2.3.0" `
`implementation "androidx.room:room-runtime:$room_version" `
`annotationProcessor "androidx.room:room-compiler:$room_version"`

`def lifecycle_version = "2.3.1"`

`def lifecycle_version_old = "2.2.0" `
`// ViewModel `
`implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version" `
`// LiveData `
`implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version" `
`// Lifecycles only (without ViewModel or LiveData) `
`implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version" `
`// Annotation processor`
`annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
// alternately - if using Java8, use the following instead of lifecycle-compiler implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version" `
`//viewmodel provider `
`implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version_old"`
`//for retrofit-model conversion`
`implementation 'com.google.code.gson:gson:2.8.6'`
