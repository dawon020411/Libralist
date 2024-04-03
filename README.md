# LibraList

## List your books and search it !!

>### What will the application do?
>- **Tracking** the books the users stored within the list.
>- **Store** the title, the author, the publisher, and the publication date of the books.
>- **Search** for the stored book by filters.
>- **View** the book's information.

>### Who will use it?
>- The user that want efficient manager of readings that the user has read.

>### Why is this project of interest to you?
>- I have a lot of books in my shelf, but when I want to find the books, I cannot easily remember the title of the book.
>- Sometimes, I remember only the publication date or the author of the books, but not the title.
>- So, I want to search the book's information that I want with filter by genre, or the author's name.

---
## User Stories

>- *As a user*, I want to be able to add my books' information.
>- *As a user*, I want to be able to view stored book list.
>- *As a user*, I want to be able to search the books' title with other information.
>- *As a user*, I want to be able to see the number of books.
>- *As a user*, I want to be able to see the books by genre filter.
>- *As a user*, I want to be able to save my to-do list to file (if I so choose)
>- *As a user*, I want to be able to be able to load my to-do list from file (if I so choose)

---
## Instructions for Grader
- You can generate the first required action (add a book) related to the user story "adding multiple Xs to a Y" 
by filling the 'title', 'author', 'publisher', 'publication date', and 'genre' text fields and pressing the 'Add' 
button.
- You can generate the second required action (search a book) related to the user story "adding multiple Xs to a Y"
by filling at least one of text fields and pressing 'Search' button.
- You can locate my visual component by backgrounds of each panel.
- You can save the state of my application by clicking the 'Save Your Library' button in main page.
- You can reload the state of my application by clicking the 'Load Your Library' button in main page.

---
## Phase 4: Task 2
>- A book is added to the Library.
>- A book is searched from the Library.
>- The number of books in the Library is counted.
>- A book is searched by genre from the Library.
---
## Phase 4: Task 3
For now, when the book is added, the program produces a message that the book is added, and user can check
that the library is updated when user select the 'Display BookList' button. Observer objects receive the notification and automatically update the screen to immediately show the book added by the user.
So, it is following the Observer pattern. If I had more time, I would apply Singleton pattern and Refactoring to my GUI.
For now, JsonReader and JsonWriter can have several instances, however, with singleton pattern, I can make that the JsonReader
and JsonWriter classes share a single instance. This prevents unnecessary instance creation and save memory.
Moreover, it reduces dependencies between classes and improves maintainability.

By refactoring, I would divide the GUI class by the functionalities, such as AddBookUI, DisplayBookUI, SearchBookUI. 
For now, my GUI class is too long, and not following 'Single Responsibility Principle,' so I can improve the cohesion
and make each class function for single responsibility. Also, I can extract the duplicated code inside the methods, 
ane make it as new method that would be implemented. Additionally, we can expect improvement of Composite pattern by dividing the classes.