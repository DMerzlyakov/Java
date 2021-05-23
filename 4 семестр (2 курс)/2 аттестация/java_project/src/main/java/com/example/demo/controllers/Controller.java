package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.List;


@RestController
@RequestMapping("api/data")
public class Controller {

    private final RoleRepo roleRepo;
    private final StatusRepo statusRepo;
    private final StatusTaskRepo statusTaskRepo;
    private final TaskRepo taskRepo;
    private final UserRepo userRepo;


    public Controller(RoleRepo roleRepo, StatusRepo statusRepo, StatusTaskRepo statusTaskRepo,
                      TaskRepo taskRepo, UserRepo userRepo) {
        this.roleRepo = roleRepo;
        this.statusRepo = statusRepo;
        this.statusTaskRepo = statusTaskRepo;
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }


    @PostMapping("/users")
    User createUser(@RequestParam String firstName, @RequestParam String lastName,
                    @RequestParam String middleName, @RequestParam String password,
                    @RequestParam String login) {

        User user = new User(firstName, lastName, middleName, password, login);
        return this.userRepo.save(user);
    }


    @DeleteMapping("/deleteUser")
    User deleteUser(@RequestParam Long id) {
        User user = this.userRepo.findUserByRowId(id);
        this.userRepo.delete(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User newUser) {
        User user = this.userRepo.findUserByRowId(newUser.getRowId());
        user.setRowId(newUser.getRowId());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setMiddleName(newUser.getMiddleName());
        user.setLogin(newUser.getLogin());
        user.setPasswordHash(newUser.getPasswordHash());

        return this.userRepo.save(user);
    }

    @PostMapping("/roles")
    Role createRole(@RequestParam String name) {
        Role role = new Role(name);
        return this.roleRepo.save(role);
    }

    @PostMapping("/status")
    Status createStatus(@RequestParam String name) {
        Status status = new Status(name);
        return this.statusRepo.save(status);
    }

    @PostMapping("/statusTasks")
    StatusTask createStatusTask(@RequestBody String statusTask) throws JSONException {
        JSONObject rawStatusTask = new JSONObject(statusTask);
        StatusTask task = new StatusTask(rawStatusTask.getString("name"));
        task.setStatus(this.statusRepo.findStatusByRowId(rawStatusTask.getJSONObject("status").getLong("rowid")));
        return this.statusTaskRepo.save(task);

    }

    @GetMapping("/GetUser/{id}")
    User getUser(@PathVariable Long id) {
        return this.userRepo.findUserByRowId(id);
    }


    @GetMapping("/GetRole/{name}")
    Role getRole(@PathVariable String name) {
        return this.roleRepo.findRoleByName(name);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/tasks")
    Task createTask(@RequestBody Task task) {
        return this.taskRepo.save(task);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/task/all")
    List<Task> getTask() {
        return this.taskRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/task/{id}")
    Task getTask(@PathVariable Long id) {
        return this.taskRepo.findTaskByRowId(id);
    }

}
