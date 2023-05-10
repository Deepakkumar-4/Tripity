package com.example.tripity.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripity.Adapters.ArchaeologyPlaceAdapter;
import com.example.tripity.R;
import com.example.tripity.TicketBookingActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView featuredArchaeologyRecyclerView;
    private RecyclerView popularArchaeologyRecyclerView;
    private ArchaeologyPlaceAdapter featuredArchaeologyAdapter;
    private ArchaeologyPlaceAdapter popularArchaeologyAdapter;

    private ImageButton booking;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the RecyclerViews in the layout
        featuredArchaeologyRecyclerView = rootView.findViewById(R.id.featured_archaeology_recycler_view);
        popularArchaeologyRecyclerView = rootView.findViewById(R.id.popular_archaeology_recycler_view);

        //clicking button for booking layout
        booking = rootView.findViewById(R.id.bookTicket);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), TicketBookingActivity.class);
                startActivity(intent);

            }
        });

        // Set up the RecyclerViews with a LinearLayoutManager and an adapter
        featuredArchaeologyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        popularArchaeologyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        featuredArchaeologyAdapter = new ArchaeologyPlaceAdapter(getFeaturedArchaeologyPlaces());
        popularArchaeologyAdapter = new ArchaeologyPlaceAdapter(getPopularArchaeologyPlaces());
        featuredArchaeologyRecyclerView.setAdapter(featuredArchaeologyAdapter);
        popularArchaeologyRecyclerView.setAdapter(popularArchaeologyAdapter);

        return rootView;
    }

    private List<ArchaeologyPlace> getFeaturedArchaeologyPlaces() {
        // TODO: Implement logic to retrieve featured archaeological places from a data source
        // For now, return a hardcoded list of sample places
        List<ArchaeologyPlace> places = new ArrayList<>();
        places.add(new ArchaeologyPlace("Taj Mahal", "Agra", R.drawable.tajmahal,"\n" +
                "\n" +
                "Taj Mahal is a magnificent white marble mausoleum located in the northern Indian city of Agra. It was built by Mughal emperor Shah Jahan in memory of his beloved wife Mumtaz Mahal, who died during childbirth in 1631. Construction of the Taj Mahal began in 1632 and was completed in 1653, with the help of over 20,000 workers.\n" +
                "\n" +
                "The Taj Mahal is considered to be one of the finest examples of Mughal architecture, which is a blend of Islamic, Persian, and Indian architectural styles. The monument's symmetrical design features a central dome flanked by four smaller domes, with minarets on each corner of the platform. The structure is adorned with intricate carvings, inlaid with precious stones, and inscriptions from the Quran.\n" +
                "\n" +
                "The Taj Mahal's construction required the use of various materials from different parts of India and other countries. The white marble was quarried in Rajasthan, while the precious stones used in the inlay work were sourced from various regions of India, Persia, and Central Asia.\n" +
                "\n" +
                "Today, the Taj Mahal is considered one of the world's most famous landmarks and attracts millions of visitors from around the globe. It is recognized as a UNESCO World Heritage Site and is considered a symbol of love, beauty, and architectural excellence."));
        places.add(new ArchaeologyPlace("Qutub Minar", "Delhi", R.drawable.qutubminar,"Qutub Minar is a tall minaret located in the Qutub complex in the Mehrauli area of Delhi, India. It was built in the early 13th century by Qutub-ud-din Aibak, the first ruler of the Delhi Sultanate, and his successor Iltutmish. The tower stands at a height of 73 meters (240 feet) and has five distinct stories, each with a projecting balcony.\n" +
                "\n" +
                "The tower is made of red sandstone and marble and is decorated with intricate carvings and verses from the Quran. The first three stories are made of red sandstone, while the fourth and fifth stories are made of marble and sandstone. The minaret is also surrounded by several other historic structures, including the Quwwat-ul-Islam Mosque, which is one of the oldest mosques in India.\n" +
                "\n" +
                "The Qutub Minar has survived several earthquakes and other natural disasters over the centuries, and its durability and strength are a testament to the advanced engineering skills of its builders. It has become a popular tourist attraction and is recognized as a UNESCO World Heritage Site.\n" +
                "\n" +
                "The tower is also surrounded by several other ancient ruins and monuments, including the Iron Pillar of Delhi, which is a 7-meter-high (23-foot) rust-resistant pillar that dates back to the 4th century AD. The Qutub complex is a must-visit destination for anyone interested in exploring India's rich history and architectural heritage."));
        places.add(new ArchaeologyPlace("Ajanta Caves", "Aurangabad", R.drawable.agentacaves,"The Ajanta Caves are a series of Buddhist rock-cut cave monuments located in the Aurangabad district of the Indian state of Maharashtra. The caves were built in two phases, with the first phase dating back to the 2nd century BCE to the 1st century CE, and the second phase dating back to the 5th century CE.\n" +
                "\n" +
                "The Ajanta Caves are known for their exquisite frescoes and sculptures that depict the life and teachings of the Buddha. The paintings and sculptures are considered masterpieces of Indian art and are among the finest surviving examples of ancient Indian art. The caves also feature elaborate architectural details such as ornate pillars, carved gateways, and decorative ceilings.\n" +
                "\n" +
                "The Ajanta Caves consist of 30 rock-cut Buddhist cave monuments, including chaitya halls (prayer halls) and viharas (monasteries), which were carved out of the rock face of a horseshoe-shaped gorge along the Waghora River. The caves are arranged in two groups, with the first group of caves being excavated during the Satavahana period and the second group during the Vakataka period.\n" +
                "\n" +
                "The Ajanta Caves were rediscovered in 1819 by a British hunting party, and their discovery sparked a renewed interest in Indian art and culture. Today, the Ajanta Caves are a UNESCO World Heritage Site and are a popular tourist destination. Visitors can explore the caves and marvel at the intricate paintings and sculptures, which continue to inspire artists and scholars from around the world."));
        return places;
    }

    private List<ArchaeologyPlace> getPopularArchaeologyPlaces() {
        // TODO: Implement logic to retrieve popular archaeological places from a data source
        // For now, return a hardcoded list of sample places
        List<ArchaeologyPlace> places = new ArrayList<>();
        places.add(new ArchaeologyPlace("Fatehpur Sikri", "Agra", R.drawable.fatehpursikri,"Fatehpur Sikri is a historic fortified city located in the Agra district of Uttar Pradesh in India. The city was founded by Mughal emperor Akbar in the late 16th century and served as his capital for about 14 years before being abandoned due to a shortage of water.\n" +
                "\n" +
                "Fatehpur Sikri is known for its impressive Mughal architecture, including the Jama Masjid, which is one of the largest mosques in India, and the Buland Darwaza, which is a massive gateway that stands 54 meters (177 feet) tall and is considered one of the finest examples of Mughal architecture.\n" +
                "\n" +
                "The city is also home to several other palaces, mosques, and tombs, including the Diwan-i-Khas, which is a hall of private audience, and the Panch Mahal, which is a five-story palace that was used as a pleasure pavilion by the emperor.\n" +
                "\n" +
                "Fatehpur Sikri is also known for its unique blend of Hindu and Muslim architectural styles, which is reflected in the design of the city's buildings and monuments. The city's layout and architecture are a testament to the Mughal Empire's cultural and artistic achievements, and its inclusion as a UNESCO World Heritage Site is a recognition of its importance to India's cultural heritage.\n" +
                "\n" +
                "Today, Fatehpur Sikri is a popular tourist destination, and visitors can explore the city's historic buildings and monuments, as well as its bustling bazaars and markets."));
        places.add(new ArchaeologyPlace("Ellora Caves", "Aurangabad", R.drawable.elloracaves,"The Ellora Caves are a series of rock-cut cave temples located in the Aurangabad district of the Indian state of Maharashtra. The caves were excavated from the basalt cliffs of the Charanandri Hills between the 6th and 10th centuries CE and represent a remarkable fusion of Buddhist, Jain, and Hindu art and architecture.\n" +
                "\n" +
                "The Ellora Caves consist of 34 monasteries and temples, including 12 Buddhist caves, 17 Hindu caves, and 5 Jain caves. The most notable of these caves is the Kailasa Temple, which is a massive structure that was carved from a single piece of rock and is considered one of the largest monolithic structures in the world.\n" +
                "\n" +
                "The caves are renowned for their intricate carvings, sculptures, and paintings, which depict a wide range of religious themes and mythological scenes. The caves are also notable for their architectural features, including pillared halls, ornate facades, and intricately carved ceilings.\n" +
                "\n" +
                "The Ellora Caves are a testament to the artistic and engineering skills of the ancient Indian craftsmen and are recognized as a UNESCO World Heritage Site. Today, they are a popular tourist destination, attracting visitors from all over the world who come to marvel at the beauty and complexity of these ancient structures."));
        places.add(new ArchaeologyPlace("Hampi", "Karnataka", R.drawable.vijayavittla,"The Vijaya Vittala Temple is a historic temple located in Hampi, Karnataka, India. It is considered one of the most important and impressive temples in Hampi and is known for its stunning architecture and intricate carvings.\n" +
                "\n" +
                "The temple is dedicated to Lord Vittala, a form of Lord Vishnu, and was built during the reign of King Krishnadevaraya of the Vijayanagara Empire in the 16th century CE. The temple features a massive stone chariot, which is one of the most iconic symbols of Hampi, as well as several other impressive structures, including a pillared hall, a sanctum sanctorum, and a large courtyard.\n" +
                "\n" +
                "One of the most unique features of the Vijaya Vittala Temple is its musical pillars, which produce different musical notes when struck. The temple also has a beautifully carved stone mantapa (pavilion) and a shrine dedicated to Garuda, the mythical bird and vehicle of Lord Vishnu.\n" +
                "\n" +
                "The Vijaya Vittala Temple is renowned for its intricate carvings and sculptures, which depict scenes from Hindu mythology and the daily lives of people during the Vijayanagara period. The temple's architecture is a testament to the artistic and engineering skills of the craftsmen of that time.\n" +
                "\n" +
                "Today, the Vijaya Vittala Temple is a popular tourist attraction, and visitors from all over the world come to Hampi to marvel at its beauty and learn about the rich history and culture of the Vijayanagara Empire."));
        return places;
    }

}
