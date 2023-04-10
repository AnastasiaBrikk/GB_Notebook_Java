package notebook.util;
import notebook.controller.UserController;
import notebook.dao.impl.FileOperation;
import notebook.repository.GBRepository;
import notebook.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

public class Running {
    public Running() {
        startNotebook();
    }

    private void startNotebook() { 
        try { 
            createDB();
            FileOperation fileOperation = new FileOperation(DB_PATH);
            GBRepository repository = new UserRepository(fileOperation);
            UserController controller = new UserController(repository);
            UserView view = new UserView(controller);
            view.run();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
