package ru.mail.polis.homework.processor;

public class RegexProcessor implements TextProcessor {
    private final ProcessingStage stage = ProcessingStage.PROCESSING;
    private final String regex;
    private final String replacement;

    public RegexProcessor(String regex, String replacement) {
        this.regex = regex;
        this.replacement = replacement;
    }

    @Override
    public String execute(String text) {
        return text.replaceFirst(regex, replacement);
    }

    @Override
    public ProcessingStage getStage() {
        return stage;
    }
}
