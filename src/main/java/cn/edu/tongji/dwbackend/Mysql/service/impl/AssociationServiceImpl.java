package
        cn.edu.tongji.dwbackend.Mysql.service.impl;/**
 * @author 梁乔 2021/12/6
 **/

import cn.edu.tongji.dwbackend.Mysql.entity.MovieEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewActorNameEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewCategoryNameEntity;
import cn.edu.tongji.dwbackend.Mysql.entity.ViewDirectorNameEntity;
import cn.edu.tongji.dwbackend.Mysql.repository.*;
import cn.edu.tongji.dwbackend.Mysql.service.AssociationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 此处写RelationShipServiceImpl类的描述
 * @author 梁乔
 * @since 2021/12/6 22:00 
 */

@Service
public class AssociationServiceImpl implements AssociationService {
    @Resource
    MovieRepository movieRepository;

    @Resource
    DirectorMovieRepository directorMovieRepository;

    @Resource
    ViewDirectorNameRepository viewDirectorNameRepository;

    @Resource
    ViewActorNameRepository viewActorNameRepository;

    @Resource
    ViewCategoryNameRepository viewCategoryNameRepository;

    @Override
    public List<String> getMovieNameByStr(String movieString) {
        Pageable pageable = PageRequest.of(0, 25);
        List<MovieEntity> movieList = movieRepository.findAllByMovieNameStartingWith(movieString, pageable);

        List<String> result = new ArrayList<>();
        for (MovieEntity movie: movieList){
            result.add(movie.getMovieName());
        }

        return result;
    }

    @Override
    public List<String> getDirectorNameByStr(String directorName){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewDirectorNameEntity> directorList =
                viewDirectorNameRepository.findAllByDirectorNameStartingWith(directorName, pageable);

        List<String> result = new ArrayList<>();
        for (ViewDirectorNameEntity director: directorList){
            result.add(director.getDirectorName());
        }

        return result;
    }

    @Override
    public List<String> getActorNameByStr(String actorName){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewActorNameEntity> actorList =
                viewActorNameRepository.findAllByActorNameStartingWith(actorName, pageable);

        List<String> result = new ArrayList<>();
        for (ViewActorNameEntity actor: actorList){
            result.add(actor.getActorName());
        }

        return result;
    }

    @Override
    public List<String> getCategoryNameByStr(String category){
        Pageable pageable = PageRequest.of(0, 50);
        List<ViewCategoryNameEntity> categoryList =
                viewCategoryNameRepository.findAllByCategoryNameStartingWith(category, pageable);

        List<String> result = new ArrayList<>();
        for (ViewCategoryNameEntity categoryName: categoryList){
            result.add(categoryName.getCategoryName());
        }

        return result;
    }
}