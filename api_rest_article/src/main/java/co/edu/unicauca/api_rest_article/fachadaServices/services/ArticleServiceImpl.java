package co.edu.unicauca.api_rest_article.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_article.capaAccesoADatos.models.ArticleEntity;
import co.edu.unicauca.api_rest_article.capaAccesoADatos.repositories.ArticleRepository;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ArticleWithConferencesDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;
import co.edu.unicauca.api_rest_article.rabbit.MessageProducer;

@Service
public class ArticleServiceImpl implements IArticleService{

    private ArticleRepository servicioAccesoBaseDatos;
	private ConferenceService servicioAccesoBaseDatosConferencia;
	private ModelMapper modelMapper;
	private final MessageProducer producer;

    public ArticleServiceImpl(ArticleRepository servicioAccesoBaseDatos, ConferenceService ConferenceService,ModelMapper modelMapper, MessageProducer producer) {
		this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
		this.modelMapper = modelMapper;
		this.servicioAccesoBaseDatosConferencia = ConferenceService;
		this.producer = producer;
	}

	@Override
	public List<ArticleDTO> findAll() {

		List<ArticleEntity> articlesEntity = this.servicioAccesoBaseDatos.findAll();
		List<ArticleDTO> articleDTO = this.modelMapper.map(articlesEntity, new TypeToken<List<ArticleDTO>>() {
		}.getType());
		return articleDTO;
	}

	@Override
	public ArticleDTO findById(Integer id) {
		ArticleEntity objArticleEntity = this.servicioAccesoBaseDatos.findById(id);
		ArticleDTO ArticleDTO = null;
		if(objArticleEntity!=null) {
			ArticleDTO = this.modelMapper.map(objArticleEntity, ArticleDTO.class);
		}
		return ArticleDTO;
	}

	@Override
	public ArticleDTO save(ArticleDTO articulo) {
		ArticleEntity ArticleEntity = this.modelMapper.map(articulo, ArticleEntity.class);
		ArticleEntity objArticleEntity = this.servicioAccesoBaseDatos.save(ArticleEntity);
		ArticleDTO ArticleDTO = this.modelMapper.map(objArticleEntity, ArticleDTO.class);
		producer.sendMessage(ArticleDTO);
		return ArticleDTO;
	}

	@Override
	public ArticleDTO update(Integer id, ArticleDTO articulo) {
		ArticleEntity ArticleEntity = this.modelMapper.map(articulo, ArticleEntity.class);
		ArticleEntity ArticleEntityActualizado = this.servicioAccesoBaseDatos.update(id, ArticleEntity);
		ArticleDTO ArticleDTO = this.modelMapper.map(ArticleEntityActualizado, ArticleDTO.class);
		return ArticleDTO;
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}

    @Override
    public boolean exists(int id) {
        return this.servicioAccesoBaseDatos.exists(id);
    }

	@Override
	public List<ConferenceDTO> getConferencesByArticle(Integer idArticle) {
		return this.servicioAccesoBaseDatosConferencia.getConferencesByArticle(idArticle);
	}

	@Override
	public ArticleWithConferencesDTO getArticleWithConferences(Integer idArticle) {
		List<ConferenceDTO> conferences = this.servicioAccesoBaseDatosConferencia.getConferencesByArticle(idArticle);
		ArticleEntity objArticleEntity = this.servicioAccesoBaseDatos.findById(idArticle);
		ArticleDTO article = this.modelMapper.map(objArticleEntity, ArticleDTO.class);
		ArticleWithConferencesDTO articleWithConferences = new ArticleWithConferencesDTO(article, conferences);
		return articleWithConferences;
	}
}
