package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.repository.GBRepository;
import notebook.repository.impl.UserRepository;
import notebook.util.Commands;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    private User createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        User newUser = new User(firstName, lastName, phone);
        return newUser;
    }

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    userController.saveUser(createUser());
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                
                case READ_ALL:
                    List<User> users = userController.getAllUsers();
                    for (User user : users) {
                        System.out.println(user);
                        System.out.println("--------------");
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Введите Id контакта: ");
                    userController.updateUser(userId, createUser());
                    break;

                case DELETE:
                    String delId = prompt("Введите Id контакта для удаления: ");
                    userController.deleteById(delId);
                    break;

                case DELETE_ALL:
                    userController.delete();
                    break;
               
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.print(message);
        return in.nextLine();
    }
}
