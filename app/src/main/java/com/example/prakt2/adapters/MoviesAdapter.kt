import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prakt2.R
import com.example.prakt2.models.Movies

class MovieAdapter(private var movies: List<Movies>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieName: TextView = view.findViewById(R.id.movieName)
        val movieRating: TextView = view.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.movieName.text = item.movie
        holder.movieRating.text = item.rating.toString()
    }

    override fun getItemCount() = movies.size

    fun updateMovies(newMovies: List<Movies>) {
        this.movies = newMovies
        notifyDataSetChanged()
    }
}