# NewsCrud

## Build instructions
1. Open the file `src/main/resources/application.properties`:
   - Change the line as indicated in the instruction: `spring.datasource.password=your_password`, where `your_password` is the password for accessing your database.
   - Before the first program run, make sure that the value of `spring.jpa.hibernate.ddl-auto` is set to `spring.jpa.hibernate.ddl-auto=create`.
   - For subsequent runs, change the value of `spring.jpa.hibernate.ddl-auto` to `spring.jpa.hibernate.ddl-auto=update`.

2. Navigate to the project root and build the application with the command: `mvn clean install` or `make install`.
3. Stay in the project root and run the application with the command: `mvn spring-boot:run` or `make run`.

4. Application verification:
   - Open a browser and go to http://localhost:8080.

## Usage instructions

1. After launching the application, open a browser and go to http://localhost:8080. You will land on the main page with a news feed.
2. Adding news:
   - On the main page, click the "Add News" button in the top right.
   - On the news addition page, enter the title, publication date, news text, and choose an image (optional).
   - Then click the "Add" button.

3. Updating news:
   - Click on the ellipsis ("...") in the top right corner of the news you want to update and select "Update News".
   - Make the necessary changes to the title, publication date, news text, or image. Then click the "Update" button.

4. Deleting news:
   - Click on the ellipsis ("...") in the top right corner of the news you want to delete and select "Delete News".

5. Changing the number of news per page:
   - On the main page, use the "Number of News Per Page" dropdown to select the displayed number of news.

6. Changing the background color of news:
   - On the main page, use the form to choose the news background color to change the background color of displayed news.
   - Click the "Save Color" button.

7. Page navigation:
   - On the main page, use the bottom block with page numbers to switch between news pages.


![](https://github.com/sergek1/NewsCrud/blob/main/materials/news.gif)