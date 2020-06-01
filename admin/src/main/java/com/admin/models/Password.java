package com.admin.models;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Password {


        // SecureRandom() constructs a secure random number generator (RNG) implementing the default random number algorithm.
        private final SecureRandom RandomNo = new SecureRandom();

        private final List<Character> ValueObj;

        // Just initialize ArrayList crunchifyValueObj and add ASCII Decimal Values
        public Password() {

            ValueObj = new ArrayList<>();

            // Adding ASCII Decimal value between 33 and 53
            for (int i = 33; i < 53; i++) {
                ValueObj.add((char) i);
            }

            // Adding ASCII Decimal value between 54 and 85
            for (int i = 54; i < 85; i++) {
                ValueObj.add((char) i);
            }

            // Adding ASCII Decimal value between 86 and 128
            for (int i = 86; i < 127; i++) {
                ValueObj.add((char) i);
            }

            // crunchifyValueObj.add((char) 64);

            // rotate() rotates the elements in the specified list by the specified distance. This will create strong password
            // Totally optional
            Collections.rotate(ValueObj, 5);
        }


        // Get Char value from above added Decimal values
        // Enable Logging below if you want to debug
        public char GetRandom() {

            char Char = this.ValueObj.get(RandomNo.nextInt(this.ValueObj.size()));

            // log(String.valueOf(crunchifyChar));
            return Char;
        }

       static public String pass(){
    Password passwordGenerator = new Password();

    StringBuilder builder = new StringBuilder();

            for (int length = 0; length < 8; length++) {
                builder.append(passwordGenerator.GetRandom());
            }

            return builder.toString();


        }
}
