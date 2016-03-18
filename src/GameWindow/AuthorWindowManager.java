package GameWindow;

import GameObject.AgainButton;

/**
 * Created by Admin on 3/17/2016.
 */
public class AuthorWindowManager {
    private AuthorWindow authorWindow;

    public AuthorWindow getAuthorWindow() {
        return authorWindow;
    }


    private static AuthorWindowManager ourInstance = new AuthorWindowManager();

    public static AuthorWindowManager getInstance() {
        return ourInstance;
    }

    private AuthorWindowManager() {
        authorWindow = new AuthorWindow();
    }
}
