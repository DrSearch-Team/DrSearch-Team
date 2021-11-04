# DrSearch

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An Android mobile application where users can search, review, and recommend doctors and other medical experts in their area.

### App Evaluation
- **Category:** Health 
- **Mobile:** The application's development will be focused on mobile. However, future developments may expand this application to desktop. Most features will be accessible on mobile rather than desktop. Application will include location and maps feature.
- **Story:** People can search for a doctor via Google Maps API that displays local doctors within the general location. Clicking on a doctor displays contact information, address, and reviews about the individual. Application also allows for users to review selected doctor and provide a rating from 1 through 5. There is no comprehensive mobile application that allows users to find a well qualified doctor.
- **Market:** All individuals in need of a doctor or someone in the medical field (ex. physical therapist, speech pathologist, chiropractor).
- **Habit:** The application intends to be used when user is in need of a medical expert or is searching for a new for a medical expert. Users will use and create on the application.
- **Scope:** The application may be challenging in the following aspects: adding the Google Maps API, saving and rendering reviews from different users to a specific profile pages and businesses. First, we would start by developing a page where people are able to search for medical experts around the area. Then, users would begin rating their experiences. Future development would include ways to prevent bots and false ratings from appearing and a gamified way for medical examiners to be the first result when users are searching for one. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Login Screen (Username, password, and application logo)
* Registration Screen (Username, password, age, phone number)
* Profile Screen (Will have username, profile image, and past reviews)
* Main Screen (Include search for doctors, stream of doctors around the area)
* Favorites Screen (The page will include doctors favorited by the user)
* Details Screen (Will provide further information about a specific doctor)
* Compose Screen (Enables users to write a review)

**Optional Nice-to-have Stories**
* Have an email requirement for registrations
* The main screen should also include the doctor's phone number
* Detail screen will include hours of operation, rating, and reviews
* Doctors Nearby option
* Have a Google Maps API interface in detail screen
* Rate doctors based on user experience


### 2. Screen Archetypes

* Login Screen
   * When first opening the app, it prompts users to log in or create an account
   * After logging in for the first time, create persistence after logging in
* Register Screen
   * Allows users without accounts to create an account
   * Allow users to upload their profile image
* Stream Screen
   * Allows users to search for doctors by distance (10, 25, 50, 100 miles) from current location
   * Allows users to search by keywords (ex. primary care physician, orthodontist)
* Detail Screen
   * Allows users to read more information about a specific doctor
   * Renders reviews of specific doctor from other users
* Creation Screen
   * Allows users to write a review about their experience with a doctor
* Profile Screen
   * Allows users to see their user information (ex. username, join date, profile image)
   * Allows users to see past reviews they have written
   * Allows users to log out of application



### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Profile
* Search/Reviews
* Favorites 

**Flow Navigation** (Screen to Screen)

* Forced Log-in -> Account creation if no login is available
* Main/Search -> Detail Screen -> comment/compose
* Main/Search -> User screen
* Main/Search -> Favorites 

## Wireframes

### [BONUS] Digital Wireframes & Mockups
<img src="wireframe.png" width=600>

### [BONUS] Interactive Prototype
<img src="prototype.gif" width=250>

## Schema 
[This section will be completed in Unit 9]

### Models
[Add table of models]

### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]


