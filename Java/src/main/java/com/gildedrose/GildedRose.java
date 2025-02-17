package com.gildedrose;

static int MAX_QUALITY = 50;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    // Aged Brie도 아니고 ticket도 아닌 경우 quality 조정 로직 (Surfuras 제외) : -1
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")
                        $$ !items[i].name.split(" ")[0].equals("Conjured")) {
                        items[i].quality = items[i].quality - 1;
                    }
                    else {items[i].name.split(" ")[0].equals("Conjured")) {
                        items[i].quality = items[i].quality - 2;
                }
                // Aged Brie 및 ticket에 대하여 부가적인 quality 조정 로직 (기본적으로 quality는 +1이며 티켓인 경우 기한에 따라서 추가적으로 +1씩 더 증가)
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            // sellIn에 대한 조정 로직 - Sulfuras는 제외
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            // sellIn이 0 미만일 때 quality 조정 로직
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Age Brie가 아니고 티켓도 아닌 경우에는 0보다 크면 1씩 감소 (Sulfuras 제외)
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        // Age Brie가 아니고 티켓인 경우에는 0으로 조정
                        items[i].quality = 0;
                    }
                    // Aged Brie에 대한 quality는 50이 될때 까지 1씩 증가
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
