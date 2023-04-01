package br.unifaj.aula4.carrorecycleviewapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CarViewHolder extends RecyclerView.ViewHolder {
    TextView carName;
    TextView carPrice;
    TextView carColor;
    TextView carPlate;

    public CarViewHolder(View view) {
        super(view);

        this.carName = itemView.findViewById(R.id.card_car_name);
        this.carPrice = itemView.findViewById(R.id.card_car_price_textview);
        this.carColor = itemView.findViewById(R.id.card_car_color_textview);
        this.carPlate = itemView.findViewById(R.id.card_car_plate_textview);
    }

    public void setCar(Car car) {
        Locale localeBR = new Locale( "pt", "BR" );
        NumberFormat moneyBRL = NumberFormat.getCurrencyInstance(localeBR);

        carName.setText(car.name);
        carPlate.setText("Placa: " + car.plate);
        carColor.setText("Cor: " + car.color);
        carPrice.setText(moneyBRL.format(car.price));
    }
}
