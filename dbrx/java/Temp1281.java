package com.springboot.reserving.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Temp1281 {
    public static void main(String[] args) {
        // Main method implementation
    }

    @Repository
    public interface MemberRepository extends CrudRepository<Member, Long> {
        // Repository methods
    }

    @Entity
    public static class Member {
        @Id
        private Long id;
        // Other member fields and methods
    }
}