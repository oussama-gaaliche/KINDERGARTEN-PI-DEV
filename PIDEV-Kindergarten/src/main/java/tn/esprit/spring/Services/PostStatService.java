package tn.esprit.spring.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.CountWord;
import tn.esprit.spring.entity.poststats;

import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.PostStatRepository;
import tn.esprit.spring.repository.WordCountRepository;

@Service
@Transactional

public class PostStatService implements IPostStatService {

	@Autowired
	PostStatRepository StatisticRepository;
	@Autowired
	PostStatRepository post;
	@Autowired
	 WordCountRepository poste;
	@Autowired
	PostStatRepository ks;
	@Autowired
	 WordCountRepository kt;

	@Override
	public List<?> retrieveWord() {

		return StatisticRepository.listPostStat();
	}

	public String[] seleccontained() {
		List<poststats> post2 = post.findAll();
		for (poststats br : post2) {

			post.delete(br);
		}
		String[] ab = ks.selectcontained();
		for (int i = 0; i < ab.length; i++) {

			String dc = ab[i];
			String[] words = dc.split(" ", 3);
			for (String word : words) {
				System.out.println(word);
				poststats a = new poststats();
				if (word.equals(" "))
					a.setWords("null");
				else {
					a.setWords(word);
				}
				post.save(a);
			}

		}
		List<poststats> post1 = post.findAll();
		for (poststats br : post1) {
			if (br.getWords().equals("") || br.getWords().length()==1 ) {
				post.delete(br);
			}

		}

		return ks.selectcontained();

	}

	@Override
	public int nbrofreposts(String word) {
		return ks.calculnbrofreposts(word);

	}

	@Override
	public void setRepition() {

		List<List<String>> l = post.countwords();
		List<CountWord> post2 = poste.findAll();
		for (CountWord br : post2) {

			poste.delete(br);
		}

		for (int i = 0; i < l.size(); i++) {
			System.err.println((l.get(i).get(1)));
			System.err.println((l.get(i).get(0)));
			CountWord countword = new CountWord();
			countword.setNbrRepi(Integer.parseInt(l.get(i).get(1)));
			countword.setWord((l.get(i).get(0)));
			kt.save(countword);

		}

	}

}
