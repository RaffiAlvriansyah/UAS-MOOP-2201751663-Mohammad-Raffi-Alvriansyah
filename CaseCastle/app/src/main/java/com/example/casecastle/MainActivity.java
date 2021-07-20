package com.example.casecastle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casecastle.gameplay.ArmyArcher;
import com.example.casecastle.gameplay.ArmyCavalry;
import com.example.casecastle.gameplay.ArmyInfantry;
import com.example.casecastle.gameplay.Castle;
import com.example.casecastle.gameplay.CastleHorse;
import com.example.casecastle.gameplay.CastleSteel;
import com.example.casecastle.gameplay.Heroes;
import com.example.casecastle.gameplay.HeroesArcher;
import com.example.casecastle.gameplay.HeroesCatapult;
import com.example.casecastle.gameplay.HeroesCavalry;
import com.example.casecastle.gameplay.HeroesInfantry;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView title, textLeft, textRight;
    private ImageView castleRight, winRight, castleLeft, winLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Activity myActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.fightNowBtn);
        title = findViewById(R.id.textTitle);
        textLeft = findViewById(R.id.castleTextLeft);
        textRight = findViewById(R.id.castleTextRight);
        castleRight = findViewById(R.id.castleRight);
        castleLeft = findViewById(R.id.castleLeft);
        winRight = findViewById(R.id.winRight);
        winLeft = findViewById(R.id.winLeft);

        initFirstBattle();
    }

    private void initFirstBattle() {
        CastleHorse horse = new CastleHorse("Horse");
        CastleSteel steel = new CastleSteel("Steel");
        title.setText("Cavalry vs Infantry");

        for (int i = 0; i < 5; i++) {
            horse.addHero(new HeroesCavalry("Cavalry", 100, 100));
        }
        for (int i = 0; i < 100000; i++) {
            horse.addArmy(new ArmyCavalry("Cavalry", 100, 100));
        }

        for (int j = 0; j < 5; j++) {
            steel.addHero(new HeroesInfantry("Infantry", 100, 100));
        }
        for (int j = 0; j < 100000; j++) {
            steel.addArmy(new ArmyInfantry("Infantry", 100, 100));
        }
        initCastleImageBattle(horse, steel);

        btn.setOnClickListener(view -> firstBattle(horse, steel));
    }

    //First battle (Cavalry vs Infantry)
    private void firstBattle(CastleHorse horse, CastleSteel steel) {
        horse.initTroops();
        steel.initTroops();

        int horseCavalry = horse.getCavalryCount();
        int steelInfantry = steel.getInfantryCount();

        horseCavalry -= 0.1 * steel.getInfantryCount();
        steelInfantry -= 0.4 * horse.getCavalryCount();

        textLeft.setText(String.format(Locale.US, "Remain: %d Cavalry", horseCavalry));
        textRight.setText(String.format(Locale.US, "Remain: %d Infantry", steelInfantry));

        if (horseCavalry > steelInfantry) {
            winLeft.setVisibility(View.VISIBLE);
        } else {
            winRight.setVisibility(View.VISIBLE);
        }
        btn.setText("Next Battle");
        btn.setOnClickListener(view -> initSecondBattle());
    }

    private void initSecondBattle() {
        winRight.setVisibility(View.INVISIBLE);
        winLeft.setVisibility(View.INVISIBLE);
        textRight.setText("");
        textLeft.setText("");

        CastleSteel steel = new CastleSteel("Steel");
        CastleHorse horse = new CastleHorse("Horse");
        title.setText("Infantry vs (Cavalry + Range)");

        for (int j = 0; j < 5; j++) {
            steel.addHero(new HeroesInfantry("Infantry", 100, 100));
        }
        for (int j = 0; j < 100000; j++) {
            steel.addArmy(new ArmyInfantry("Infantry", 100, 100));
        }

        for (int i = 0; i < 3; i++) {
            horse.addHero(new HeroesCavalry("Cavalry", 100, 100));
        }
        for (int i = 0; i < 2; i++) {
            horse.addHero(new HeroesArcher("Archer", 100, 100));
        }
        for (int i = 0; i < 50000; i++) {
            horse.addArmy(new ArmyCavalry("Cavalry", 100, 100));
        }
        for (int i = 0; i < 50000; i++) {
            horse.addArmy(new ArmyArcher("Archer", 100, 100));
        }

        initCastleImageBattle(steel, horse);
        btn.setText("FIGHT");
        btn.setOnClickListener(v -> secondBattle(steel, horse));
    }

    //Second battle (Infantry vs Cavalry and Range)
    private void secondBattle(CastleSteel steel, CastleHorse horse) {
        steel.initTroops();
        horse.initTroops();

        int steelInfantry = steel.getInfantryCount();
        int horseCavalry = horse.getCavalryCount();
        int horseArcher = horse.getArcherCount();

        steelInfantry -= 0.4 * horse.getCavalryCount();
        steelInfantry -= 0.1 * horse.getArcherCount();

        horseCavalry -= 0.1 * steel.getInfantryCount();
        horseArcher -= 0.1 * steel.getInfantryCount();

        textLeft.setText(String.format(Locale.US, "Remain: %d Infantry", steelInfantry));
        textRight.setText(String.format(Locale.US, "Remain: %d Cavalry and %d Archer", horseCavalry, horseArcher));

        if (steelInfantry > horseCavalry + horseArcher) {
            winLeft.setVisibility(View.VISIBLE);
        } else {
            winRight.setVisibility(View.VISIBLE);
        }
        btn.setText("END");
        btn.setOnClickListener(v -> finish());
    }

    private void initCastleImageBattle(Castle castle1, Castle castle2) {
        //assume castles has 2 members
        loadCastleImage(castleLeft, castle1);
        loadCastleImage(castleRight, castle2);
    }

    private void loadCastleImage(ImageView iView, Castle ct) {
        Heroes leader = ct.getHeroes().get(0);

        if (leader instanceof HeroesArcher) {
            iView.setBackgroundResource(R.drawable.archer);
        } else if (leader instanceof HeroesCatapult) {
            iView.setBackgroundResource(R.drawable.catapult);
        } else if (leader instanceof HeroesCavalry) {
            iView.setBackgroundResource(R.drawable.cavalry);
        } else {
            iView.setBackgroundResource(R.drawable.infantry);
        }
    }
}