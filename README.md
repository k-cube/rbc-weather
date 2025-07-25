Weather app (RBC Interview Project)

- I used Open-Meteo for both weather data and location search.
- The app contains a Main screen that has a search bar that responds to input using a Flow with a 300ms debounce, and a Details screen.
- The API doesn’t provide hourly data for future days, so the hourly chart is only available for the current day and is shown in the MainScreen instead of DetailsScreen, as initially planned. 
The DetailsScreen now just shows static weather info for the selected day and doesn't need state management and a ViewModel.
- A location permission Flow is implemented so the app reacts properly when the permission dialog is accepted.
- I used Type-Safe Jetpack Navigation. While it's usually recommended to pass only minimal data (like an ID) and fetch details in the destination screen, I’m passing a slightly more complex object due to the small scale of the app and lack of caching or a separate endpoint for details.
- I used Dispatcher Injection so the ViewModel can be tested using a MainDispatcherRule class that overrides TestWatcher. Without this, it’s harder to run assertions at the right time or wait for coroutine tasks to complete.
- I wrote some unit tests for the ViewModel and some UI tests. With more time, I would have added more coverage, such as tests for the repositories.
- And finally, like many developers, I don’t have the best design sense, but I did my best! It might not be the most beautiful design ever :)

<img width="300" alt="Screenshot_20250725_134958" src="https://github.com/user-attachments/assets/ac03fa1d-d1e6-46e6-b4f6-cb0765232187" />
<img width="300" alt="Screenshot_20250725_141202" src="https://github.com/user-attachments/assets/381e355b-2b11-4973-b1b4-a14563552ab1" />
<img width="300"  alt="Screenshot_20250725_141213" src="https://github.com/user-attachments/assets/5a3804d3-ca1f-4d27-a355-9edf9a4d327c" />
<img width="300" alt="Screenshot_20250725_141311" src="https://github.com/user-attachments/assets/65ab9d4e-7974-4a8a-b405-73c09401460c" />
<img width="300" alt="Screenshot_20250725_141128" src="https://github.com/user-attachments/assets/8028f1d4-6fa7-44f2-abef-85c8b40e37a7" />
<img width="300" alt="Screenshot_20250725_141323" src="https://github.com/user-attachments/assets/924d413d-28da-48e5-8f94-152e72dc289c" />

