package com.example.utilities;

import com.example.entities.GroupEntity;
import com.example.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchGroupsUtil {
    public static List<List<String>> constructList(List<GroupEntity> groups){
        List<List<String>> groupDates = new ArrayList<>();
        for (GroupEntity g: groups) {
            //0: name, 1: cantidad de alumnos, 2: nombre del profesor, 3: id
            groupDates.add( List.of(g.getGroupName(), String.valueOf(g.getGroup_alumns().size()), g.getGroup_teacher().getFirstName() + " " + g.getGroup_teacher().getLastName(), String.valueOf(g.getId()) ));
        }
        return groupDates;
    }
    public static List<List<String>> getGroupDatesPerTeacher(GroupRepository groupRepository, String username){
        List<GroupEntity> groups = groupRepository.findByTeacherUsername(username);
        return constructList(groups);
    }

    public static List<List<String>> getAllGroupDates(GroupRepository groupRepository){
        List<GroupEntity> groups = groupRepository.findAll();
        return constructList(groups);
    }
    public static Optional<GroupEntity> getGroupById(GroupRepository groupRepository, Long groupId) {
        return groupRepository.findById(groupId);
    }
}
