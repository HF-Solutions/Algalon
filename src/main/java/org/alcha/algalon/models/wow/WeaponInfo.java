package org.alcha.algalon.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 15:36.</p>
 */

public class WeaponInfo {
    static class Damage {
        private int min;
        private int max;
        private int exactMin;
        private int exactMax;

        public static Damage newInstanceFromJson(JsonObject jsonObject) {
            Damage damage = new Damage();

            if (jsonObject.has("min"))
                damage.setMin(jsonObject.get("min").getAsInt());
            else damage.setMin(-1);

            if (jsonObject.has("max"))
                damage.setMax(jsonObject.get("max").getAsInt());
            else damage.setMax(-1);

            if (jsonObject.has("exactMin"))
                damage.setExactMin(jsonObject.get("exactMin").getAsInt());
            else damage.setExactMin(-1);

            if (jsonObject.has("exactMax"))
                damage.setExactMax(jsonObject.get("exactMax").getAsInt());
            else damage.setExactMax(-1);

            return damage;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getExactMin() {
            return exactMin;
        }

        public void setExactMin(int exactMin) {
            this.exactMin = exactMin;
        }

        public int getExactMax() {
            return exactMax;
        }

        public void setExactMax(int exactMax) {
            this.exactMax = exactMax;
        }
    }

    private Damage mDamage;
    private float mWeaponSpeed;
    private float mDPS;

    public WeaponInfo() {

    }

    public static WeaponInfo newInstanceFromJson(JsonObject jsonObject) {
        WeaponInfo info = new WeaponInfo();

        if (jsonObject.has("damage"))
            info.setDamage(Damage.newInstanceFromJson(jsonObject.getAsJsonObject("damage")));
        else info.setDamage(new Damage());

        if (jsonObject.has("weaponSpeed"))
            info.setWeaponSpeed(jsonObject.get("weaponSpeed").getAsFloat());
        else info.setWeaponSpeed(-1);

        if (jsonObject.has("dps"))
            info.setDPS(jsonObject.get("dps").getAsFloat());
        else info.setDPS(-1);

        return info;
    }

    public Damage getDamage() {
        return mDamage;
    }

    public void setDamage(Damage damage) {
        mDamage = damage;
    }

    public float getWeaponSpeed() {
        return mWeaponSpeed;
    }

    public void setWeaponSpeed(float weaponSpeed) {
        mWeaponSpeed = weaponSpeed;
    }

    public float getDPS() {
        return mDPS;
    }

    public void setDPS(float DPS) {
        mDPS = DPS;
    }
}
