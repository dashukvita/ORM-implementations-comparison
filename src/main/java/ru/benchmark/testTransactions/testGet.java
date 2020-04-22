package ru.benchmark.testTransactions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.jpa.tests.TestCollectionPerson.dao.PersonCollectionDaoEclipseLink;
import ru.jpa.tests.TestCollectionPerson.test.EclipseLinkTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.HibernateTestPersonCollection;
import ru.jpa.tests.TestCollectionPerson.test.OpenJPATestPersonCollection;
import ru.jpa.tests.TestIndexedPerson.dao.PersonIndexedDaoEclipseLink;
import ru.jpa.tests.TestIndexedPerson.test.EclipseLinkTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.HibernateTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.MyBatisTestPersonIndexed;
import ru.jpa.tests.TestIndexedPerson.test.OpenJPATestPersonIndexed;
import ru.jpa.tests.TestInheritancePerson.dao.PersonExtDaoEclipseLink;
import ru.jpa.tests.TestInheritancePerson.test.EclipseLinkTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.HibernateTestPersonExt;
import ru.jpa.tests.TestInheritancePerson.test.OpenJPATestPersonExt;
import ru.jpa.tests.TestOneToManyPerson.dao.PersonOneToManyDaoEclipseLink;
import ru.jpa.tests.TestOneToManyPerson.test.EclipseLinkTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.HibernateTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.MyBatisTestPersonOneToMany;
import ru.jpa.tests.TestOneToManyPerson.test.OpenJPATestPersonOneToMany;
import ru.jpa.tests.TestPerson.dao.PersonDaoEclipseLink;
import ru.jpa.tests.TestPerson.test.EclipseLinkTestPerson;
import ru.jpa.tests.TestPerson.test.HibernateTestPerson;
import ru.jpa.tests.TestPerson.test.MyBatisTestPerson;
import ru.jpa.tests.TestPerson.test.OpenJPATestPerson;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class testGet {
    public int num = 1000;

    public static void main(String[] args) throws RunnerException {
        System.err.close();
        System.setErr(System.out);
        testGet test = new testGet();
        test.createEntityForTest();

        Options opt = new OptionsBuilder()
                .include(testGet.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    public void createEntityForTest(){
        PersonDaoEclipseLink dao = new PersonDaoEclipseLink();
        dao.save(num);

        PersonOneToManyDaoEclipseLink daoOtM = new PersonOneToManyDaoEclipseLink();
        daoOtM.save(num);

        PersonExtDaoEclipseLink daoExt = new PersonExtDaoEclipseLink();
        daoExt.save(num);

        PersonIndexedDaoEclipseLink daoInd = new PersonIndexedDaoEclipseLink();
        daoInd.save(num);

        PersonCollectionDaoEclipseLink daoCol = new PersonCollectionDaoEclipseLink();
        daoCol.save(num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonEclipseMethod() {
        new EclipseLinkTestPerson().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonHibernateMethod() {
        new HibernateTestPerson().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOpenJPAMethod() {
        new OpenJPATestPerson().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonMyBatisMethod() {
        new MyBatisTestPerson().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmEclipseMethod() {
        new EclipseLinkTestPersonOneToMany().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmHibernateMethod() {
        new HibernateTestPersonOneToMany().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmOpenJPAMethod() {
        new OpenJPATestPersonOneToMany().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonOtmMyBatisMethod() {
        new MyBatisTestPersonOneToMany().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedEclipseMethod() {
        new EclipseLinkTestPersonIndexed().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedHibernateMethod() {
        new HibernateTestPersonIndexed().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedOpenJPAMethod() {
        new OpenJPATestPersonIndexed().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonIndexedMyBatisMethod() {
        new MyBatisTestPersonIndexed().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtEclipseMethod() {
        new EclipseLinkTestPersonExt().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtHibernateMethod() {
        new HibernateTestPersonExt().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonExtOpenJPAMethod() {
        new OpenJPATestPersonExt().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColEclipseMethod() {
        new EclipseLinkTestPersonCollection().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColHibernateMethod() {
        new HibernateTestPersonCollection().getAllPersons();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void getTestPersonColOpenJPAMethod() {
        new OpenJPATestPersonCollection().getAllPersons();
    }
}
