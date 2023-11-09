package com.example.utilities;

import com.example.entities.GroupEntity;
import com.example.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchGroupsUtil {
    public List<List<String>> constructList(List<GroupEntity> groups){
        List<List<String>> groupDates = new ArrayList<>();
        for (GroupEntity g: groups) {
            groupDates.add( List.of(g.getGroupName(), String.valueOf(g.getGroup_alumns().size()), g.getGroup_teacher().getFirstName() + " " + g.getGroup_teacher().getLastName() ));
        }
        return groupDates;
    }
    public List<List<String>> getGroupDatesPerTeacher(GroupRepository groupRepository, String username){
        List<GroupEntity> groups = groupRepository.findByTeacherUsername(username);
        return constructList(groups);
    }

    public List<List<String>> getAllGroupDates(GroupRepository groupRepository){
        List<GroupEntity> groups = groupRepository.findAll();
        return constructList(groups);
    }
}
