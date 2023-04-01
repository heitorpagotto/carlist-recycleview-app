package br.unifaj.aula4.carrorecycleviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class CarRecycleViewAdapter extends RecyclerView.Adapter<CarViewHolder> {
    ArrayList<Car> cars = new ArrayList<>();

    public CarRecycleViewAdapter() {
        for (int i =0; i <= 10000; i++) {
            cars.add(new Car(
                    "Carro " + (i + 1),
                    generateRandomPlate(),
                    generateRandomColor(),
                    generateRandomPrice()
            ));
        }
    }

    private double generateRandomPrice() {
        Random randomNumbers = new Random();
        return 20000 + (1000000 - 20000) * randomNumbers.nextDouble();
    }

    private String generateRandomColor() {
        String[] colors = {"Prata", "Preto", "Branco", "Azul", "Vermelho", "Azul Marinho", "Amarelo", "Verde", "Laranja", "Roxo"};

        Random randomNumbers = new Random();
        int randomIdx = randomNumbers.nextInt(colors.length - 0) + 0;

        return colors[randomIdx];
    }
    private String generateRandomPlate() {
        char[] alphabet = ("abcdefghijklmnopqrstuvwxyz").toUpperCase().toCharArray();
        String finalPlate = "";
        for (int i = 0; i < 3; i++) {
            Random randomNumbers = new Random();
            int randomIdx = randomNumbers.nextInt(25 - 0) + 0;

            finalPlate += alphabet[randomIdx];
        }
        for (int i = 0;i<4;i++) {
            finalPlate += Math.round(Math.ceil(Math.random() * 9));
        }

        return finalPlate;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_card_view, parent, false);
        CarViewHolder viewHolder = new CarViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.setCar(car);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
