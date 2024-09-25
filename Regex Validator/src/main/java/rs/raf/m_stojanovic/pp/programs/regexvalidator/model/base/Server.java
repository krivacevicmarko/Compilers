package rs.raf.m_stojanovic.pp.programs.regexvalidator.model.base;

import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.NamedRegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.RegexSourceBase;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.UsableRegexSource;
import rs.raf.m_stojanovic.pp.programs.regexvalidator.model.utility.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static Server server;

    public static Server getServer() {
        if (server == null) {
            synchronized (Server.class) {
                if (server == null)
                    server = new Server();
            }
        }
        return server;
    }

    private final List<RegexSource> regexSources = new ArrayList<>(FileUtils.listAll());

    private Server() {

    }

    public final NamedRegexSource convertToNamedRegexSource(RegexSource regexSource) {
        int index = this.regexSources.indexOf(regexSource);
        if (index == -1)
            return null;
        if (regexSource instanceof RegexSourceBase) {
            RegexSourceBase regexSourceBase = (RegexSourceBase) regexSource;
            try {
                NamedRegexSource namedRegexSource = regexSourceBase.toNamedRegexSource();
                this.regexSources.set(index, namedRegexSource);
                return namedRegexSource;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    public final UsableRegexSource convertToUsableRegexSource(RegexSource regexSource) {
        int index = this.regexSources.indexOf(regexSource);
        if (index == -1)
            return null;
        if (regexSource instanceof NamedRegexSource) {
            NamedRegexSource namedRegexSource = (NamedRegexSource) regexSource;
            UsableRegexSource usableRegexSource = namedRegexSource.toUsableRegexSource();
            this.regexSources.set(index, usableRegexSource);
            return usableRegexSource;
        }
        return null;
    }

    public final void addRegexSourceBase(RegexSourceBase regexSourceBase) {
        if (!this.regexSources.contains(regexSourceBase))
            this.regexSources.add(regexSourceBase);
    }

    public final List<RegexSource> getRegexSources() {
        return new ArrayList<>(this.regexSources);
    }
}
