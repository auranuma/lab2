package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_2.databinding.FragmentMainBinding
import com.example.lab_2.model.Book

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            layoutManager.orientation
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        val bookList = listOf(
            Book(
                name = "To Kill a Mockingbird",
                shortDescription = "Classic novel about racial injustice",
                description = "To Kill a Mockingbird is a novel by Harper Lee published in 1960. It tells the story of Scout Finch, a young girl growing up in the fictional town of Maycomb, Alabama, during the 1930s. The book explores themes of racial injustice, compassion, and the loss of innocence.",
                url = "https://cdn.britannica.com/21/182021-050-666DB6B1/book-cover-To-Kill-a-Mockingbird-many-1961.jpg"
            ),
            Book(
                name = "1984",
                shortDescription = "Dystopian novel by George Orwell",
                description = "1984 is a dystopian novel by George Orwell published in 1949. The story takes place in a totalitarian society where the government monitors and controls every aspect of people's lives. The novel explores themes of government surveillance, propaganda, and the erosion of individual freedom.",
                url = "https://m.media-amazon.com/images/I/519zR2oIlmL._AC_UF1000,1000_QL80_.jpg"
            ),
            Book(
                name = "Pride and Prejudice",
                shortDescription = "Jane Austen's classic romance",
                description = "Pride and Prejudice is a novel by Jane Austen published in 1813. It follows the story of Elizabeth Bennet, a young woman in 19th-century England, as she navigates social status, love, and family expectations. The book is renowned for its wit, social commentary, and memorable characters.",
                url = "https://m.media-amazon.com/images/M/MV5BMDM0MjFlOGYtNTg2ZC00MmRkLTg5OTQtM2U5ZjUyYTgxZThiXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg"
            ),
            Book(
                name = "The Great Gatsby",
                shortDescription = "F. Scott Fitzgerald's Jazz Age masterpiece",
                description = "The Great Gatsby is a novel by F. Scott Fitzgerald published in 1925. Set during the Roaring Twenties, the story explores themes of wealth, love, and the American Dream through the eyes of the enigmatic Jay Gatsby. It is considered one of the greatest American novels of all time.",
                url = "https://upload.wikimedia.org/wikipedia/commons/7/7a/The_Great_Gatsby_Cover_1925_Retouched.jpg"
            ),
            Book(
                name = "Harry Potter and the Philosopher's Stone",
                shortDescription = "First book in the Harry Potter series",
                description = "Harry Potter and the Philosopher's Stone is the first book in J.K. Rowling's Harry Potter series. It introduces the young wizard Harry Potter as he starts his magical journey at Hogwarts School of Witchcraft and Wizardry. The book captures the imagination of readers with its magical world and captivating characters.",
                url = "https://www.bigw.com.au/medias/sys_master/images/images/h4e/hee/29656777588766.jpg"
            ),
            Book(
                name = "The Lord of the Rings",
                shortDescription = "Epic fantasy trilogy by J.R.R. Tolkien",
                description = "The Lord of the Rings is an epic fantasy trilogy by J.R.R. Tolkien. It follows the journey of a group of characters, including Frodo Baggins, as they embark on a quest to destroy the One Ring and defeat the Dark Lord Sauron. The books are known for their rich world-building, complex characters, and timeless themes.",
                url = "https://images.penguinrandomhouse.com/cover/9780593500484"
            )
        )

        val adapter = BookAdapter(bookList, findNavController())

        binding.recyclerView.adapter = adapter
    }


}
