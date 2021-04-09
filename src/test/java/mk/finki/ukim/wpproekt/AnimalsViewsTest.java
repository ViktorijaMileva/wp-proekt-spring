package mk.finki.ukim.wpproekt;

import mk.finki.ukim.wpproekt.model.views.AnimalsPerBreedView;
import mk.finki.ukim.wpproekt.repository.views.AnimalsPerBreedViewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalsViewsTest {

    @Autowired
    private AnimalsPerBreedViewRepository animalsPerBreedViewRepository;

    @Test
    public void testAnimalsPerBreedViewRepositoryFindAll(){
        List<AnimalsPerBreedView> list = this.animalsPerBreedViewRepository.findAll();
        Assert.assertEquals(2, list.size());
    }
}
