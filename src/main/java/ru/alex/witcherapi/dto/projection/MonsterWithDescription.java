package ru.alex.witcherapi.dto.projection;


import org.springframework.beans.factory.annotation.Value;

public interface MonsterWithDescription {
    Long getId();
    String getName();
    String getImgName();
    String getSource();

    @Value("#{target.monsterDescription.quote}")
    String getQuote();

    @Value("#{target.monsterDescription.quoteAuthor}")
    String getQuoteAuthor();

    @Value("#{target.monsterDescription.description}")
    String getDescription();
}
