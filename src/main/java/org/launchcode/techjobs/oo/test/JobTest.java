package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job job1;
    Job job2;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job3.getName() == "Product tester");
        assertThat(job3.getEmployer(), instanceOf(Employer.class));
        assertThat(job3.getLocation(), instanceOf(Location.class));
        assertThat(job3.getPositionType(), instanceOf(PositionType.class));
        assertThat(job3.getCoreCompetency(), instanceOf(CoreCompetency.class));
    }

    @Test
    public void testJobsForEquality() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job3.equals(job4));
    }

    @Test
    public void toStringTest1() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String str = job4.toString();
        Character firstLine = str.charAt(0);
        Character lastLine = str.charAt(str.length() - 1);

        assertTrue(firstLine.equals('\n'));
        assertTrue(lastLine.equals('\n'));
    }

    @Test
    public void toStringTest2() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String str = job4.toString();
        String str1 = str.substring(1);
        String str2 = str1.substring(0, str1.length() - 1);
        String test = "ID: 3\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence";

        assertTrue(str2.equals(test));
    }

    @Test
    public void toStringTest3() {
        Job job4 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = job4.toString().split("\\r?\\n");
        String name = lines[2].substring(6);
        String conditionStr = "Data not available";

        assertTrue(name.equals(conditionStr));
    }

    @Test
    public void toStringTestBonus() {
        Job job4 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String str = job4.toString();
        String conditionStr = "OOPS! This job does not seem to exist.";

        assertTrue(str.equals(conditionStr));
    }
}
