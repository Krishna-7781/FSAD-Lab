package com.klh.service;

import com.klh.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    // ADD COURSE
    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    // GET ALL COURSES
    public List<Course> getAllCourses() {
        return courses;
    }

    // GET COURSE BY ID
    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // UPDATE COURSE
    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    // DELETE COURSE
    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    // SEARCH COURSE BY TITLE
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}
